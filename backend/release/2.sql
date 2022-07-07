--for create
create table "appOrders"
(
    "id" INTEGER not null primary key,
    "bkCustomerId" INTEGER,
    "bkProductId" INTEGER,
    "bkWarehouseId" INTEGER,
    "bkWarehouseOutId" INTEGER,
    "coneSediment" FLOAT(7),
    "construction" VARCHAR(255),
    "createAt" TIMESTAMP,
    "startTime" TIMESTAMP,
    "endTime" TIMESTAMP,
    "createdUser" VARCHAR(255),
    "cubicMeter" FLOAT(7),
    "intervalMinutes" INTEGER,
    "intervalComment" VARCHAR(255),
    "status" varchar(20)
);


-- alter table "wMain" drop constraint RDB$FOREIGN122;
select * from rdb$relation_constraints where "RDB$RELATION_NAME" = 'wMain';
select * from rdb$relation_constraints where "RDB$RELATION_NAME" = 'appOrders';
alter table "wMain" drop  constraint ("appOrder") references "appOrders";
alter table "wMain" add foreign key ("appOrder") references "appOrders";
update unique index "RDB$PRIMARY119"
          on "appOrders"("id");

alter table "appOrders"
    add or update constraint INTEG_611
               primary key ("id");
--for update
alter table "appOrders"
    add "startTime" TIMESTAMP,
    add "endTime" TIMESTAMP,
    add "intervalMinutes" INTEGER,
    add "intervalComment" VARCHAR(255)


;