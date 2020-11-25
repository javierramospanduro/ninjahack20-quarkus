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