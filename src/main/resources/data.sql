DROP TABLE IF EXISTS public.employees;
CREATE TABLE IF NOT EXISTS public.employees
(
    id bigint NOT NULL,
    date_started date,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    location character varying(255) COLLATE pg_catalog."default",
    manager character varying(255) COLLATE pg_catalog."default",
    role character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employees_pkey PRIMARY KEY (id)
    );
INSERT INTO public.employees(
    id, date_started, email, first_name, last_name, location, manager, role)
VALUES (999, '1980-01-01', 'aabbcc', 'aabbcc', 'aabbcc', 'aabbcc', 'aabbcc', 'aabbcc');