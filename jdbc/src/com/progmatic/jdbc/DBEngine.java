package com.progmatic.jdbc;

import com.progmatic.jdbc.valami.Ugyfel;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DBEngine {
    private Connection connection;


    public Connection getConnection() {
        if (this.connection != null) {
        }
        return this.connection;
    }
    public DBEngine() {

//        String url = String.format(
//                "jdbc:mysql://%s:%s/%s",
//                System.getenv("progmatic_db_host"),
//                System.getenv("progmatic_db_port"),
//                System.getenv("progmatic_db_name")
//        );
        String url = "jdbc:mysql://95.111.248.108:16603/pm2201_MG";

        Properties prop = new Properties(2);
        prop.put("user", "MG");
        prop.put("password", "mento");

//        prop.put("user", System.getenv("progmatic_db_user"));
//        prop.put("password", System.getenv("progmatic_db_passwd"));

        try {
            this.connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            System.out.println("HIBA a kapcsolat letrehozasa soran");
        }
    }

    public List<Ugyfel> getAllClient() {
        String getQuery = "SELECT * FROM ugyfel";

        List<Ugyfel> all = new LinkedList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getQuery);

            while (rs.next()) {
                Ugyfel tmp = new Ugyfel(
                        rs.getLong("azon"),
                        rs.getInt("szulEv"),
                        rs.getInt("irszam"),
                        rs.getString("nev"),
                        rs.getString("orsz")
                );

                all.add(tmp);

            }
        } catch (SQLException e) {
            // do nothing
        }

        return all;
    }


    public List<String> getAllClientCountries () {
        String getQuery =  "SELECT nev, orsz FROM ugyfel GROUP BY nev";

        List<String> all = new LinkedList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getQuery);

            all.add(rs.getString("orszag"));

        } catch (SQLException e) {
            // do nothing
        }

        return all;

    }













}