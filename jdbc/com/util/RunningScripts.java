package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

public class RunningScripts {
	public void runDbScript() throws Exception
	{
		ScriptRunner sr = new ScriptRunner(DbUtil.getConnection());
		Reader reader = new BufferedReader(new FileReader("/projects/challenge/JDBC/db.sql"));
		sr.runScript(reader);
	}
}
