create table "appOrders"
(
    ID INTEGER not null
        constraint "PK_wOrders"
            primary key
--     "TranspNum" VARCHAR(30)
--         constraint "wOrders_IDX3"
--             unique,
--     "Driver" VARCHAR(30),
--     "Description" VARCHAR(100),
--     "InvoiceNum" VARCHAR(20),
--     "InvoiceSeria" VARCHAR(10),
--     "RoadDoc" VARCHAR(20),
--     "ProductLink" INTEGER
--         constraint "FK_wOrders_1"
--             unique
--         constraint "FK_wOrders_1"
--             references "bkProducts"
--             on update cascade on delete set null,
--     "CustomerLink" INTEGER
--         constraint "FK_wOrders_2"
--             unique
--         constraint "FK_wOrders_2"
--             references "bkCustomers"
--             on update cascade on delete set null,
--     "VendorLink" INTEGER
--         constraint "FK_wOrders_3"
--             unique
--         constraint "FK_wOrders_3"
--             references "bkCustomers"
--             on update cascade on delete set null,
--     "TransporterLink" INTEGER
--         constraint "FK_wOrders_4"
--             unique
--         constraint "FK_wOrders_4"
--             references "bkCustomers"
--             on update cascade on delete set null,
--     "PayerLink" INTEGER
--         constraint "FK_wOrders_7"
--             unique
--         constraint "FK_wOrders_7"
--             references "bkCustomers"
--             on update cascade on delete set null,
--     "WarehouseLink" INTEGER
--         constraint "FK_wOrders_5"
--             unique
--         constraint "FK_wOrders_5"
--             references "bkWarehouses"
--             on update cascade on delete set null,
--     "WarehouseOutLink" INTEGER
--         constraint "FK_wOrders_6"
--             unique
--         constraint "FK_wOrders_6"
--             references "bkWarehouses"
--             on update cascade on delete set null,
--     "CreateAt" TIMESTAMP(19) not null,
--     "JobStartAt" TIMESTAMP(19)
--         constraint "wOrders_IDX1"
--             unique,
--     "JobFinishAt" TIMESTAMP(19),
--     "Author" INTEGER not null,
--     "Tare" INTEGER,
--     "RunCount" INTEGER,
--     "TrailerNum" VARCHAR(30)
);

