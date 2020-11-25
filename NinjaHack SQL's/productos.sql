-- Table: kids."T_PRODUCTOS"

-- DROP TABLE kids."T_PRODUCTOS";

CREATE TABLE kids."T_PRODUCTOS"
(
    "ID_PRODUCTO" character(10) COLLATE pg_catalog."default" NOT NULL,
    "DESCRIPCION" character(40) COLLATE pg_catalog."default" NOT NULL,
    "IMP_PRECIO" numeric(15, 2) NOT NULL,
    "NIVEL" character(3) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "T_PRODUCTOS_pkey" PRIMARY KEY ("ID_PRODUCTO")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_PRODUCTOS"
    OWNER to postgres;