CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `rms`.`v_inventory_sum` AS
    SELECT 
        UUID() AS `id`,
        `rms`.`product`.`product_id` AS `product_id`,
        `rms`.`product`.`party_id` AS `party_id`,
        `rms`.`product`.`status` AS `status`,
        `rms`.`product`.`weight_id` AS `weight_id`,
        `rms`.`product`.`quantity_id` AS `quantity_id`,
        `rms`.`product`.`product_code` AS `product_code`,
        `rms`.`product`.`product_name` AS `product_name`,
        COALESCE(SUM(`rms`.`inventory`.`gross_weight`), 0) AS `gross_weight`,
        COALESCE(SUM(`rms`.`inventory`.`qty`), 0) AS `qty`,
        `rms`.`weight_profile`.`weight_unit` AS `weight_unit`,
        `rms`.`quantity_profile`.`quantity_unit` AS `quantity_unit`
    FROM
        (((`rms`.`product`
        LEFT JOIN `rms`.`inventory` ON ((`rms`.`product`.`product_id` = `rms`.`inventory`.`product_id`)))
        LEFT JOIN `rms`.`weight_profile` ON ((`rms`.`product`.`weight_id` = `rms`.`weight_profile`.`weight_id`)))
        LEFT JOIN `rms`.`quantity_profile` ON ((`rms`.`product`.`quantity_id` = `rms`.`quantity_profile`.`quantity_id`)))
    GROUP BY `rms`.`product`.`product_id` , `rms`.`product`.`party_id` , `rms`.`product`.`status` , `rms`.`product`.`weight_id` , `rms`.`product`.`quantity_id` , `rms`.`product`.`product_code` , `rms`.`product`.`product_name` , `rms`.`weight_profile`.`weight_unit` , `rms`.`quantity_profile`.`quantity_unit`