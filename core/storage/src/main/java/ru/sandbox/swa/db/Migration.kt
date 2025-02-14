package ru.sandbox.swa.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE forecast_copy( 
                id INTEGER, 
                date TEXT,
                temperature REAL
                humidity INTEGER
                wind_speed REAL
                city_id TEXT
                PRIMARY KEY (id, city_id)
                FOREIGN KEY(city_id) REFERENCES cities(id)
            );
            INSERT INTO forecast_copy (id, date, temperature, humidity, wind_speed, city_id)
               SELECT id, date, temperature, humidity, wind_speed, city_id FROM forecast;
            DROP TABLE forecast;
            ALTER TABLE forecast_copy RENAME TO forecast;
        """.trimIndent()
        )
    }
}