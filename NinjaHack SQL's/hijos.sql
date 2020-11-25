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