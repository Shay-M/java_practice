INSERT INTO `second_digital_bank`.`AccountNumbers` (`AccountNumbersId`, `AcountsId`) VALUES (1, 1);
INSERT INTO `second_digital_bank`.`AccountNumbers` (`AccountNumbersId`, `AcountsId`) VALUES (2, 1);
INSERT INTO `second_digital_bank`.`AccountNumbers` (`AccountNumbersId`, `AcountsId`) VALUES (3, 2);

INSERT INTO `second_digital_bank`.`Acount` (`AcountsId`, `AcountNumber`, `Amount`, `Type`) VALUES (1, 1000, 5000, 1);
INSERT INTO `second_digital_bank`.`Acount` (`AcountsId`, `AcountNumber`, `Amount`, `Type`) VALUES (2, 2000, 4000, 2);
INSERT INTO `second_digital_bank`.`Acount` (`AcountsId`, `AcountNumber`, `Amount`, `Type`) VALUES (3, 3000, 3000, 3);

INSERT INTO `second_digital_bank`.`Contact` (`ContactId`, `Name`, `Email`, `PhoneNumber`) VALUES (1, 'a', 'a@a.sql.com', 1);
INSERT INTO `second_digital_bank`.`Contact` (`ContactId`, `Name`, `Email`, `PhoneNumber`) VALUES (2, 'b', NULL, 2);
INSERT INTO `second_digital_bank`.`Contact` (`ContactId`, `Name`, `Email`, `PhoneNumber`) VALUES (3, 'c', 'c@c.sql.co.il', 3);

INSERT INTO `second_digital_bank`.`CraditRating` (`CraditRatingId`, `Rating`) VALUES (1, 'A');
INSERT INTO `second_digital_bank`.`CraditRating` (`CraditRatingId`, `Rating`) VALUES (2, 'B');
INSERT INTO `second_digital_bank`.`CraditRating` (`CraditRatingId`, `Rating`) VALUES (3, 'C');
INSERT INTO `second_digital_bank`.`CraditRating` (`CraditRatingId`, `Rating`) VALUES (4, 'D');

INSERT INTO `second_digital_bank`.`Customers` (`ContactId`, `AccountNumbersId`, `Address`, `AccountType`, `CraditRaitingId`) VALUES (1, 1, 'sma', 1, 1);
INSERT INTO `second_digital_bank`.`Customers` (`ContactId`, `AccountNumbersId`, `Address`, `AccountType`, `CraditRaitingId`) VALUES (2, 2, 'no home 55', 2, 3);
INSERT INTO `second_digital_bank`.`Customers` (`ContactId`, `AccountNumbersId`, `Address`, `AccountType`, `CraditRaitingId`) VALUES (3, 3, 'this is a address', 1, 2);

INSERT INTO `second_digital_bank`.`PhoneNumber` (`PhoneId`, `Number`, `Type`) VALUES (1, 0541234567, 2);
INSERT INTO `second_digital_bank`.`PhoneNumber` (`PhoneId`, `Number`, `Type`) VALUES (2, 039087645, 1);
INSERT INTO `second_digital_bank`.`PhoneNumber` (`PhoneId`, `Number`, `Type`) VALUES (3, 100, 1);

INSERT INTO `second_digital_bank`.`PhoneType` (`PhoneId`, `Type`) VALUES (1, 'Landline');
INSERT INTO `second_digital_bank`.`PhoneType` (`PhoneId`, `Type`) VALUES (2, 'Cell phone');
INSERT INTO `second_digital_bank`.`PhoneType` (`PhoneId`, `Type`) VALUES (3, 'Fax');

INSERT INTO `second_digital_bank`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (1, 'Manager');
INSERT INTO `second_digital_bank`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (2, 'customer service');
INSERT INTO `second_digital_bank`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (3, 'Banker');
INSERT INTO `second_digital_bank`.`RoleEmployeesType` (`RoleId`, `Type`) VALUES (4, 'Demon');

INSERT INTO `second_digital_bank`.`employees`
(`ContactId`,
`Role`,
`vetak`,
`StartDate`)
VALUES
(2,
2,
3,
now()-3);









