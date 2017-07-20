CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `v_total_delivery_item` AS
    SELECT 
       `rms`.`delivery_item`.`receiving_id` AS `receiving_id`,
        IFNULL(SUM(`rms`.`delivery_item`.`item_gross_weight`),
                0) AS `item_gross_weight`,
        IFNULL(SUM(`rms`.`delivery_item`.`item_qty`), 0) AS `item_qty`
    FROM
        `rms`.`delivery_item`
    GROUP BY `rms`.`delivery_item`.`receiving_id`