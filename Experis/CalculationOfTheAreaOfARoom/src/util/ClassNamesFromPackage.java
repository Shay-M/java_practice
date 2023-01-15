package util;

import factory.ShapeCreator;
import shapes.Shape;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// this go to out put class files

public final class ClassNamesFromPackage {

    public static final String CREATE = "Create";

    private static final List<String> getPathsClassFromFolder(final Path packageName) {
        try (Stream<Path> contents = Files.list(packageName)) {
            // contents.toList();
            Stream<String> fileNamesWithoutExt = contents.map(// .getFileName()
                    path -> path.toString() // convert to string
                            .substring(4) //
                            .replace(File.separator, ".")); //
            //.split("\\.")[0]) // remove the extension from the file name
            //.filter(name -> !name.isEmpty()); //  filter empty string.

            final List<String> classNames = fileNamesWithoutExt.toList();
            // classNames.replaceAll(name -> name.replaceAll(".java", ""));

            List<String> modifiedClassNames = classNames.stream()
                    .map(name -> name.replaceAll(".java", ""))
                    .collect(Collectors.toList());
            // classNames = modifiedClassNames;

            return modifiedClassNames;
        }
        catch (IOException e) {
            return Collections.emptyList();
        }

    }

    public static HashMap<String, ShapeCreator> createClassAndKeysFromFolder(final Path packageName) {
        final List<String> classNames = getPathsClassFromFolder(packageName);

        final HashMap<String, ShapeCreator> mapOfClassesNameAndShapeCreators = new HashMap<>();
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Constructor<?> constructor = clazz.getConstructor();
                ShapeCreator shapeCreator = (ShapeCreator) constructor.newInstance();

                mapOfClassesNameAndShapeCreators.put(getClassNameShape(shapeCreator.getClass().getName()), shapeCreator);

            }
            catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                   InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return mapOfClassesNameAndShapeCreators;
    }

    private static String getClassNameShape(final String pathOfClassCreator) {
        final String newString = pathOfClassCreator
                .substring(pathOfClassCreator.lastIndexOf(".") + 1)
                .replaceAll(CREATE, "");
        return newString;
    }


    /*public static List<String> getClassNamesFromPackage(final String packageName) {
        final List<String> classNames = new ArrayList<>();
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final String packagePath = packageName.replace(".", "/");

        final Enumeration<URL> resources;
        try {
            resources = classLoader.getResources(packagePath);
            if (resources != null) {
                while (resources.hasMoreElements()) {
                    URL resource = resources.nextElement();
                    classNames.addAll(getClassNamesFromPackage(resource, packageName));
                }
            }
            return classNames;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private static List<String> getClassNamesFromPackage(final URL resource, final String packageName) throws IOException {
        final List<String> classNames = new ArrayList<>();

        try (final URLClassLoader classLoader = new URLClassLoader(new URL[]{resource})) {
            final Enumeration<URL> resources = classLoader.getResources(packageName);
            if (resources != null) {
                while (resources.hasMoreElements()) {
                    URL childResource = resources.nextElement();
                    classNames.addAll(getClassNamesFromPackage(childResource, packageName));
                }
            }
            return classNames;
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }*/
}

