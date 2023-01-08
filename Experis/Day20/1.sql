CALL sp_transferMoney(1, 3, 1);
CALL sp_transferMoney(3, 1, 1);

-- Error Code: 1146. Table 'second_digital_bank.accounts' doesn't exist

UPDATE accounts
  SET balance = balance - amount
  WHERE account_number = fromAccount;
  
  -- Increase the balance of the toAccount
  UPDATE accounts
  SET balance = balance + amount
  WHERE account_number = toAccount;
  
  
Select accounts
SET `Amount` = `Amount` - amount
WHERE AcountNumber = fromAccount;

-- CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_transferMoney`( IN fromAccount INT,  IN toAccount INT,  IN amount DOUBLE)
-- BEGIN
--   -- Check if the amount is negative
--   IF amount < 0 THEN 
--     -- Set a custom error message
--     SET @error = 'Cannot transfer a negative amount';
--     
--     -- Signal a custom error condition with the error message
--     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @error;
--   END IF;
--   
--   -- Start a transaction
--   START TRANSACTION;
--   
--   -- Decrease the balance of the fromAccount
--   UPDATE accounts
--   SET `Amount` = `Amount` - amount
--   WHERE AcountNumber = fromAccount;
--   
--   -- Increase the balance of the toAccount
--   UPDATE accounts
--   SET `Amount` = `Amount` + amount
--   WHERE AcountNumber = toAccount;
--   
--   -- Commit the transaction
--   COMMIT;
--   
--   -- Return a positive value to indicate success
--   SELECT 1 AS result;
-- END

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_transferMoney`( IN fromAccountId INT,  IN toAccountId INT,  IN ammountToTransfer BIGINT)
BEGIN
START TRANSACTION; -- 
if ((select `Amount` 
from `acounts` 
where `AcountsId` = fromAccountId) < ammountToTransfer)
then signal sqlstate '01011' set message_text = 'Cannot transfer a negative amount'; 
else 
update `acounts`
set `Amount` = `Amount` - ammountToTransfer
where `AcountsId` = fromAccountId;

UPDATE `acounts` 
SET 
    `Amount` = `Amount` + ammountToTransfer
WHERE
    `AcountsId` = toAccountId;
end if; 
COMMIT; -- for START TRANSACTION;
END

