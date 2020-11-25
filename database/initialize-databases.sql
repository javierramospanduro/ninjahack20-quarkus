-- Table: kids."T_CUENTAS"

-- DROP TABLE kids."T_CUENTAS";

CREATE TABLE kids."T_CUENTAS"
(
    "ID_CUENTA" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_HIJO" character(10) COLLATE pg_catalog."default" NOT NULL,
    "IMP_SALDO" numeric(15, 2) NOT NULL,
    "FEC_ALTA" date NOT NULL,
    "FEC_BAJA" date,
    "ACTIVO" boolean NOT NULL,
    "ID_PADRE" character(10) COLLATE pg_catalog."default",
    CONSTRAINT "PK_CUENTAS" PRIMARY KEY ("ID_CUENTA", "ID_HIJO"),
    CONSTRAINT "FK_CUENTAS" FOREIGN KEY ("ID_HIJO", "ID_PADRE")
        REFERENCES kids."T_HIJOS" ("ID_HIJO", "ID_PADRE") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_CUENTAS"
    OWNER to postgres;


-- Table: kids."T_HIJOS"

-- DROP TABLE kids."T_HIJOS";

CREATE TABLE kids."T_HIJOS"
(
    "ID_PADRE" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_HIJO" character(10) COLLATE pg_catalog."default" NOT NULL,
    "NOMBRE_HUO" character(40) COLLATE pg_catalog."default" NOT NULL,
    "FEC_ALTA" date NOT NULL,
    "FEC_BAJA" date,
    "ACTIVO" boolean NOT NULL,
    "NIVEL" character(4) COLLATE pg_catalog."default",
    "PASSWORD" character(20) COLLATE pg_catalog."default" NOT NULL,
    "IMP_MENSUAL" numeric(15, 2),
    CONSTRAINT "T_HIJOS_pkey" PRIMARY KEY ("ID_PADRE", "ID_HIJO"),
    CONSTRAINT "FK2_HIJOS" FOREIGN KEY ("NIVEL")
        REFERENCES kids."T_NIVELES" ("ID_NIVEL") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_HIJOS" FOREIGN KEY ("ID_PADRE")
        REFERENCES kids."T_PADRES" ("ID_PADRE") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_HIJOS"
    OWNER to postgres;
COMMENT ON TABLE kids."T_HIJOS"
    IS 'TABLA PARA LOS HIJOS REGISTRADOS';

-- Table: kids."T_MOVIMIENTOS"

-- DROP TABLE kids."T_MOVIMIENTOS";

CREATE TABLE kids."T_MOVIMIENTOS"
(
    "ID_MOVIMIENTO" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_CUENTA" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_TARJETA" character(10) COLLATE pg_catalog."default" NOT NULL,
    "IMP_MOVIMIENTO" numeric(15, 2) NOT NULL,
    "FEC_MOVIMIENTO" date NOT NULL,
    "DESCRIPCION" character(40) COLLATE pg_catalog."default",
    "IMP_SALDO" numeric(15, 2),
    "ID_PRODUCTO" character(10) COLLATE pg_catalog."default",
    "ID_HIJO" character(10) COLLATE pg_catalog."default",
    CONSTRAINT "PK_MOVS" PRIMARY KEY ("ID_MOVIMIENTO", "ID_CUENTA", "ID_TARJETA"),
    CONSTRAINT "FK_MOVS" FOREIGN KEY ("ID_TARJETA", "ID_HIJO", "ID_CUENTA")
        REFERENCES kids."T_TARJETAS" ("ID_TARJETA", "ID_HIJO", "ID_CUENTA") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_MOVIMIENTOS"
    OWNER to postgres;


-- Table: kids."T_NIVELES"

-- DROP TABLE kids."T_NIVELES";

CREATE TABLE kids."T_NIVELES"
(
    "ID_NIVEL" character(4) COLLATE pg_catalog."default" NOT NULL,
    "DESCRIPCION" character(40) COLLATE pg_catalog."default",
    CONSTRAINT "T_NIVELES_pkey" PRIMARY KEY ("ID_NIVEL")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_NIVELES"
    OWNER to postgres;



-- Table: kids."T_PADRES"

-- DROP TABLE kids."T_PADRES";

CREATE TABLE kids."T_PADRES"
(
    "ID_PADRE" character(10) COLLATE pg_catalog."default" NOT NULL,
    "NOMBRE" character(40) COLLATE pg_catalog."default" NOT NULL,
    "FEC_ALTA" date NOT NULL,
    "FEC_BAJA" date,
    "ACTIVO" boolean NOT NULL,
    "PASSWORD" character(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "T_PARENTS_pkey" PRIMARY KEY ("ID_PADRE")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_PADRES"
    OWNER to postgres;
COMMENT ON TABLE kids."T_PADRES"
    IS 'Tabla para los padres registrados';



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



-- Table: kids."T_TARJETAS"

-- DROP TABLE kids."T_TARJETAS";

CREATE TABLE kids."T_TARJETAS"
(
    "ID_TARJETA" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_CUENTA" character(10) COLLATE pg_catalog."default" NOT NULL,
    "ID_HIJO" character(10) COLLATE pg_catalog."default" NOT NULL,
    "FEC_ALTA" date NOT NULL,
    "FEC_BAJA" date,
    "ACTIVO" boolean NOT NULL,
    CONSTRAINT "PK_TARJETAS" PRIMARY KEY ("ID_TARJETA", "ID_CUENTA", "ID_HIJO"),
    CONSTRAINT "T_TARJETAS_ID_CUENTA_fkey" FOREIGN KEY ("ID_HIJO", "ID_CUENTA")
        REFERENCES kids."T_CUENTAS" ("ID_HIJO", "ID_CUENTA") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE kids."T_TARJETAS"
    OWNER to postgres;