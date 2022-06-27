-- curso_rest_ful.person definition

CREATE TABLE `person` (
                          `person_id` bigint NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(80) NOT NULL,
                          `last_name` varchar(80) NOT NULL,
                          `address` varchar(100) NOT NULL,
                          `gender` varchar(20) NOT NULL,
                          PRIMARY KEY (`person_id`)
);
