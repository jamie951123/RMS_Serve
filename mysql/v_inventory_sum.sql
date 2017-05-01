CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `rms`.`v_inventory_sum` AS
    SELECT 
        UUID() AS `id`,
        `rms`.`inventory`.`product_id` AS `product_id`,
        `rms`.`inventory`.`party_id` AS `party_id`,
        `rms`.`inventory`.`status` AS `status`,
        COALESCE(SUM(`rms`.`inventory`.`gross_weight`),0) AS `gross_weight`,
        `rms`.`inventory`.`gross_weight_unit` AS `gross_weight_unit`,
        COALESCE(SUM(`rms`.`inventory`.`qty`),0) AS `qty`,
        `rms`.`inventory`.`qty_unit` AS `qty_unit`,
        `rms`.`product`.`product_code` AS `product_code`,
        `rms`.`product`.`product_name` AS `product_name`
    FROM
        (`rms`.`inventory`
        LEFT JOIN `rms`.`product` ON ((`rms`.`product`.`product_id` = `rms`.`inventory`.`product_id`)))
    GROUP BY `rms`.`inventory`.`product_id` , `rms`.`inventory`.`party_id` , `rms`.`inventory`.`status` , `rms`.`inventory`.`qty_unit` , `rms`.`inventory`.`gross_weight_unit`