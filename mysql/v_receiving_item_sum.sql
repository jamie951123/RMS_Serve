CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `v_receiving_item_sum` AS
    SELECT 
        UUID() AS `id`,
        `rms`.`product`.`product_id` AS `product_id`,
        COALESCE(SUM(`rms`.`receiving_item`.`item_gross_weight`),
                0) AS `gross_weight`,
        `rms`.`weight_profile`.`weight_unit` AS `weight_unit`,
        COALESCE(SUM(`rms`.`receiving_item`.`item_qty`),
                0) AS `qty`,
        `rms`.`quantity_profile`.`quantity_unit` AS `quantity_unit`
    FROM
        (((`rms`.`product`
        LEFT JOIN `rms`.`weight_profile` ON ((`rms`.`product`.`weight_id` = `rms`.`weight_profile`.`weight_id`)))
        LEFT JOIN `rms`.`quantity_profile` ON ((`rms`.`product`.`quantity_id` = `rms`.`quantity_profile`.`quantity_id`)))
        LEFT JOIN `rms`.`receiving_item` ON ((`rms`.`product`.`product_id` = `rms`.`receiving_item`.`product_id`)))
    GROUP BY `rms`.`product`.`product_id`