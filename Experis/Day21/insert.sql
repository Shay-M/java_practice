INSERT INTO `SecondDigitalBankTest`.`AcountType` (`category_id`, `name`) VALUES (1, 'Saving');
INSERT INTO `SecondDigitalBankTest`.`AcountType` (`category_id`, `name`) VALUES (2, 'Managed');

INSERT INTO `SecondDigitalBankTest`.`Contact` (`ContactId`, `Name`, `Email`) VALUES (1, 'yosi', 'a@a.sql.com');
INSERT INTO `SecondDigitalBankTest`.`Contact` (`ContactId`, `Name`, `Email`) VALUES (2, 'pol', NULL);
INSERT INTO `SecondDigitalBankTest`.`Contact` (`ContactId`, `Name`, `Email`) VALUES (3, 'c', 'c@c.sql.co.il');
INSERT INTO `SecondDigitalBankTest`.`Contact` (`ContactId`, `Name`, `Email`) VALUES (4, 'dd', NULL);
INSERT INTO `SecondDigitalBankTest`.`Contact` (`ContactId`, `Name`, `Email`) VALUES (5, 'rr', NULL);

INSERT INTO `SecondDigitalBankTest`.`CraditRatingType` (`CraditRatingId`, `Rating`) VALUES (1, 'A');
INSERT INTO `SecondDigitalBankTest`.`CraditRatingType` (`CraditRatingId`, `Rating`) VALUES (2, 'B');
INSERT INTO `SecondDigitalBankTest`.`CraditRatingType` (`CraditRatingId`, `Rating`) VALUES (3, 'C');
INSERT INTO `SecondDigitalBankTest`.`CraditRatingType` (`CraditRatingId`, `Rating`) VALUES (4, 'D');

INSERT INTO `SecondDigitalBankTest`.`customerType` (`category_id`, `name`) VALUES (1, 'Private');
INSERT INTO `SecondDigitalBankTest`.`customerType` (`category_id`, `name`) VALUES (2, 'student');
INSERT INTO `SecondDigitalBankTest`.`customerType` (`category_id`, `name`) VALUES (3, 'employeed');

INSERT INTO `SecondDigitalBankTest`.`PhoneType` (`category_id`, `name`) VALUES (1, 'Landline');
INSERT INTO `SecondDigitalBankTest`.`PhoneType` (`category_id`, `name`) VALUES (2, 'Cell phone');
INSERT INTO `SecondDigitalBankTest`.`PhoneType` (`category_id`, `name`) VALUES (3, 'Fax');

INSERT INTO `SecondDigitalBankTest`.`Acount` (`AccountNumber`, `AcountType_category_id`, `Amount`) VALUES (1000, 1, 5000);
INSERT INTO `SecondDigitalBankTest`.`Acount` (`AccountNumber`, `AcountType_category_id`, `Amount`) VALUES (2000, 1, 4000);
INSERT INTO `SecondDigitalBankTest`.`Acount` (`AccountNumber`, `AcountType_category_id`, `Amount`) VALUES (3000, 1, 3000);

INSERT INTO `SecondDigitalBankTest`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (1, 'Manager');
INSERT INTO `SecondDigitalBankTest`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (2, 'customer service');
INSERT INTO `SecondDigitalBankTest`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (3, 'Banker');
INSERT INTO `SecondDigitalBankTest`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (4, 'Demon');

SET foreign_key_checks = 0;
INSERT INTO `SecondDigitalBankTest`.`Employee` (`Contact_ContactId`, `RoleEmployeesType_RoleId`, `StartDate`) VALUES (2, 2, '2005-04-11 00:00:00');
INSERT INTO `SecondDigitalBankTest`.`Employee` (`Contact_ContactId`, `RoleEmployeesType_RoleId`, `StartDate`) VALUES (3, 1, '2006-12-12 00:00:00');
INSERT INTO `SecondDigitalBankTest`.`Employee` (`Contact_ContactId`, `RoleEmployeesType_RoleId`, `StartDate`) VALUES (4, 1, '2006-12-12 00:00:00');
INSERT INTO `SecondDigitalBankTest`.`Employee` (`Contact_ContactId`, `RoleEmployeesType_RoleId`, `StartDate`) VALUES (5, 3, '2005-04-12 00:00:00');

INSERT INTO `SecondDigitalBankTest`.`PhoneNumber` (`Contact_ContactId`, `Number`, `PhoneType_category_id`) VALUES (1, 0541234567, 2);
INSERT INTO `SecondDigitalBankTest`.`PhoneNumber` (`Contact_ContactId`, `Number`, `PhoneType_category_id`) VALUES (1, 039087645, 1);
INSERT INTO `SecondDigitalBankTest`.`PhoneNumber` (`Contact_ContactId`, `Number`, `PhoneType_category_id`) VALUES (2, 100, 1);

INSERT INTO `SecondDigitalBankTest`.`AccountsList` (`Customer_CraditRating_CraditRatingId`, `Acount_AccountNumber`) VALUES (10, 1000);
INSERT INTO `SecondDigitalBankTest`.`AccountsList` (`Customer_CraditRating_CraditRatingId`, `Acount_AccountNumber`) VALUES (10, 2000);
INSERT INTO `SecondDigitalBankTest`.`AccountsList` (`Customer_CraditRating_CraditRatingId`, `Acount_AccountNumber`) VALUES (11, 1000);
INSERT INTO `SecondDigitalBankTest`.`AccountsList` (`Customer_CraditRating_CraditRatingId`, `Acount_AccountNumber`) VALUES (12, 3000);


INSERT INTO `SecondDigitalBankTest`.`Customer` (`CustomerNumber`, `Address`, `Contact_ContactId`, `CraditRating_CraditRatingId`, `customerType_category_id`) VALUES ('10', 'sma yosi', 1, 1, 1);
INSERT INTO `SecondDigitalBankTest`.`Customer` (`CustomerNumber`, `Address`, `Contact_ContactId`, `CraditRating_CraditRatingId`, `customerType_category_id`) VALUES ('11', 'no home 55', 2, 1, 2);
INSERT INTO `SecondDigitalBankTest`.`Customer` (`CustomerNumber`, `Address`, `Contact_ContactId`, `CraditRating_CraditRatingId`, `customerType_category_id`) VALUES ('12', 'this is a address', 2, 1, 2);




