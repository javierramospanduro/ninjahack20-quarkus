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