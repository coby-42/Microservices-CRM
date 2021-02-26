DROP SCHEMA IF EXISTS crm_lead;
CREATE SCHEMA crm_lead;
USE crm_lead;


CREATE TABLE leads(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    company_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255),
    sales_rep_id INT,
    PRIMARY KEY (id)
);
