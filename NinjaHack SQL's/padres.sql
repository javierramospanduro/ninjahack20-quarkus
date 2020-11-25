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