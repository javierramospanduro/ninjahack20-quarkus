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