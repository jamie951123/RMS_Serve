CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `v_inventory` AS
    SELECT 
        `rms`.`product`.`product_id` AS `product_id`,
        `rms`.`product`.`party_id` AS `party_id`,
        `rms`.`product`.`status` AS `status`,
        `rms`.`product`.`weight_id` AS `weight_id`,
        `rms`.`product`.`quantity_id` AS `quantity_id`,
        `rms`.`product`.`product_code` AS `product_code`,
        `rms`.`product`.`product_name` AS `product_name`,
        (`v_receiving_item_sum`.`gross_weight` - `v_delivery_item_sum`.`gross_weight`) AS `total_gross_weight`,
        `rms`.`weight_profile`.`weight_unit` AS `weight_unit`,
        (`v_receiving_item_sum`.`qty` - `v_delivery_item_sum`.`qty`) AS `total_qty`,
        `rms`.`quantity_profile`.`quantity_unit` AS `quantity_unit`
    FROM
        ((((`rms`.`product`
        LEFT JOIN `rms`.`v_receiving_item_sum` ON ((`v_receiving_item_sum`.`product_id` = `rms`.`product`.`product_id`)))
        LEFT JOIN `rms`.`v_delivery_item_sum` ON ((`v_delivery_item_sum`.`product_id` = `rms`.`product`.`product_id`)))
        LEFT JOIN `rms`.`weight_profile` ON ((`rms`.`product`.`weight_id` = `rms`.`weight_profile`.`weight_id`)))
        LEFT JOIN `rms`.`quantity_profile` ON ((`rms`.`product`.`quantity_id` = `rms`.`quantity_profile`.`quantity_id`)))