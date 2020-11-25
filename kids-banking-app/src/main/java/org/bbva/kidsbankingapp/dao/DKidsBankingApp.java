package org.bbva.kidsbankingapp.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bbva.kidsbankingapp.dto.AxisType;
import org.bbva.kidsbankingapp.dto.Operator;
import org.bbva.kidsbankingapp.mappers.AxisTypeMapper;
import org.bbva.kidsbankingapp.mappers.OperatorMapper;
import org.bbva.kidsbankingapp.utils.Queries;
import org.jboss.logging.Logger;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class DKidsBankingApp {
	private static final Logger LOG = Logger.getLogger(DKidsBankingApp.class);	
	
	@Inject
	@DataSource("enginedb")
	AgroalDataSource usersDataSource;
	
}
