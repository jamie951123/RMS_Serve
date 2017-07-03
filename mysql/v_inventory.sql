CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `rms`.`v_inventory` AS
    SELECT 
        `rms`.`product`.`product_id` AS `product_id`,
        `rms`.`product`.`party_id` AS `party_id`,
        `rms`.`product`.`status` AS `status`,
        `rms`.`product`.`weight_id` AS `weight_id`,
        `rms`.`product`.`quantity_id` AS `quantity_id`,
        `rms`.`product`.`product_code` AS `product_code`,
        `rms`.`product`.`product_name` AS `product_name`,
        ((SELECT 
                SUM(`v_receiving_item_sum`.`gross_weight`)
            FROM
                `rms`.`v_receiving_item_sum`) - (SELECT 
                SUM(`v_delivery_item_sum`.`gross_weight`)
            FROM
                `rms`.`v_delivery_item_sum`)) AS `total_gross_weight`,
        `rms`.`weight_profile`.`weight_unit` AS `weight_unit`,
        ((SELECT 
                SUM(`v_receiving_item_sum`.`qty`)
            FROM
                `rms`.`v_receiving_item_sum`) - (SELECT 
                SUM(`v_delivery_item_sum`.`qty`)
            FROM
                `rms`.`v_delivery_item_sum`)) AS `total_qty`,
        `rms`.`quantity_profile`.`quantity_unit` AS `quantity_unit`
    FROM
        ((((`rms`.`v_receiving_item_sum`
        LEFT JOIN `rms`.`v_delivery_item_sum` ON ((`v_delivery_item_sum`.`product_id` = `v_receiving_item_sum`.`product_id`)))
        LEFT JOIN `rms`.`product` ON ((`rms`.`product`.`product_id` = `v_receiving_item_sum`.`product_id`)))
        LEFT JOIN `rms`.`weight_profile` ON ((`rms`.`product`.`weight_id` = `rms`.`weight_profile`.`weight_id`)))
        LEFT JOIN `rms`.`quantity_profile` ON ((`rms`.`product`.`quantity_id` = `rms`.`quantity_profile`.`quantity_id`)))
    GROUP BY `rms`.`product`.`product_id` , `rms`.`product`.`party_id` , `rms`.`product`.`status` , `rms`.`product`.`weight_id` , `rms`.`product`.`quantity_id` , `rms`.`product`.`product_code` , `rms`.`product`.`product_name` , `rms`.`weight_profile`.`weight_unit` , `rms`.`quantity_profile`.`quantity_unit`