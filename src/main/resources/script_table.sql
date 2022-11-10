create table on_email(
email_id number,
email_from varchar2(255),
email_to varchar2(255),
owner_ref varchar2(255),
send_date_email date,
status_email integer,
subject varchar2(255),
text varchar2(4000));


select * from on_email
