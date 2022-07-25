--for release
create table "appOrders"
(
    "id" INTEGER not null primary key,
    "bkCustomerId" INTEGER,
    "bkProductId" INTEGER,
    "bkWarehouseId" INTEGER,
    "bkWarehouseOutId" INTEGER,
    "coneSediment" float(8),--float(8)
    "construction" VARCHAR(255),
    "createAt" TIMESTAMP,
    "startTime" TIMESTAMP,
    "endTime" TIMESTAMP,
    "createdUser" VARCHAR(255),
    "cubicMeter" float(8),--float(8)
    "intervalMinutes" INTEGER,
    "intervalComment" VARCHAR(255),
    "status" varchar(20),
    "rejectReason" VARCHAR(255)
);

drop table "appOrders" with constraints ;
alter table "appOrders" drop constraint "RDB$PRIMARY125" ;


create table "appOrdersWmain"
(
    "id" INTEGER not null primary key,
    "appOrderId" INTEGER references "appOrders",
    "wMainId" INTEGER references "wMain"
)


create table "appOrdersWorder"
(
    "id" INTEGER not null primary key,
    "appOrderId" INTEGER references "appOrders",
    "wOrderId" INTEGER references "wOrders"
)





------------------------

alter table "appOrders" 	add "rejectReason" VARCHAR(255);
alter table "wMain" add foreign key ("appOrder") references "appOrders";
alter table "wOrders" 	add "appOrder" INTEGER;
alter table "wOrders" add foreign key ("appOrder") references "appOrders";




-- alter table "wMain" drop constraint RDB$FOREIGN122;
select * from rdb$relation_constraints where "RDB$RELATION_NAME" = 'wMain';
select * from rdb$relation_constraints where "RDB$RELATION_NAME" = 'appOrders';
alter table "wMain" drop  constraint ("appOrder") references "appOrders";
alter table "wOrders" drop  "appOrder";
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