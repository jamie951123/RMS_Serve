CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `v_receiving_outstanding2` AS
    SELECT 
        `total_receiving_item`.`order_id` AS `order_id`,
        `total_receiving_item`.`receiving_id` AS `receiving_id`,
        IFNULL((`total_receiving_item`.`item_gross_weight` - `total_delivery_item`.`item_gross_weight`),
                `total_receiving_item`.`item_gross_weight`) AS `item_gross_weight`
    FROM
        (`rms`.`total_receiving_item`
        LEFT JOIN `rms`.`total_delivery_item` ON ((`total_receiving_item`.`receiving_id` = `total_delivery_item`.`receiving_id`)))