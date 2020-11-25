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