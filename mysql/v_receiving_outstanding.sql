CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW .`v_receiving_outstanding` AS
    SELECT 
        `rms`.`receiving_item`.`order_id` AS `order_id`,
        `rms`.`receiving_item`.`receiving_id` AS `receiving_id`,
        (`rms`.`receiving_item`.`item_gross_weight` - (SELECT 
                IFNULL(SUM(`rms`.`delivery_item`.`item_gross_weight`),
                            0) AS `item_gross_weight`
            FROM
                `rms`.`delivery_item`
            WHERE
                (`rms`.`receiving_item`.`receiving_id` = `rms`.`delivery_item`.`receiving_id`))) AS `item_gross_weight`
    FROM
        (`rms`.`receiving_item`
        LEFT JOIN `rms`.`delivery_item` ON ((`rms`.`receiving_item`.`receiving_id` = `rms`.`delivery_item`.`receiving_id`)))
    GROUP BY `rms`.`receiving_item`.`receiving_id` , `rms`.`receiving_item`.`order_id`