insert into product (ID, DESCRIPTION, PRODUCT_NAME)
    values (1, 'Ferramenta de integração para marketplaces', 'Gubee Integrador');
insert into product (ID, DESCRIPTION, PRODUCT_NAME)
    values (2, 'Ferramenta para gestão e calculo de fretes', 'Gubee Fretes');
insert into product (ID, DESCRIPTION, PRODUCT_NAME)
    values (3, 'Ferramenta especialistas em detecção e prevenção à fraude', 'Gubee AntiFraude');

insert into target_market(ID, NAME)
    values (1, 'Ecommerce');
insert into target_market(ID, NAME)
    values (2, 'ERP');
insert into target_market(ID, NAME)
    values (3, 'Lojista que não desejam possuir ecommerce');
insert into target_market(ID, NAME)
    values (4, 'Loja fisica');
insert into target_market(ID, NAME)
    values (5, 'Telecom');
insert into target_market(ID, NAME)
    values (6, 'Venda direta');
insert into target_market(ID, NAME)
    values (7, 'Mobile First');
insert into target_market(ID, NAME)
    values (8, 'Digital Onboarding');

insert into stack (ID, NAME)
    values (1, 'Java 10');
insert into stack (ID, NAME)
    values (2, 'Kotlin');
insert into stack (ID, NAME)
    values (3, 'Kafka');
insert into stack (ID, NAME)
    values (4, 'Event Stream');
insert into stack (ID, NAME)
    values (5, 'Redis');
insert into stack (ID, NAME)
    values (6, 'MongoDB');
insert into stack (ID, NAME)
    values (7, 'NodeJS');
insert into stack (ID, NAME)
    values (8, 'Big Data Analytics');
insert into stack (ID, NAME)
    values (9, 'Hadoop');
insert into stack (ID, NAME)
    values (10, 'Pig');
insert into stack (ID, NAME)
    values (11, 'Cassandra');

insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (1, 1);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (1, 2);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (1, 3);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (2, 1);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (2, 2);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (2, 4);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (3, 1);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (3, 5);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (3, 6);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (3, 7);
insert into product_target_market (PRODUCT_ID, TARGET_MARKET_ID)
    values (3, 8);

insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 1);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 2);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 3);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 4);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 5);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (1, 6);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (2, 7);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (2, 6);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (3, 8);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (3, 9);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (3, 3);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (3, 10);
insert into product_stack (PRODUCT_ID, STACK_ID)
    values (3, 11);