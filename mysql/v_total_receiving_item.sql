CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `v_total_receiving_item` AS
    SELECT 
        `rms`.`receiving_item`.`order_id` AS `order_id`,
        `rms`.`receiving_item`.`receiving_id` AS `receiving_id`,
        IFNULL(SUM(`rms`.`receiving_item`.`item_gross_weight`),
                0) AS `item_gross_weight`,
        IFNULL(SUM(`rms`.`receiving_item`.`item_qty`),
                0) AS `item_qty`
    FROM
        `rms`.`receiving_item`
    GROUP BY `rms`.`receiving_item`.`receiving_id` , `rms`.`receiving_item`.`order_id`