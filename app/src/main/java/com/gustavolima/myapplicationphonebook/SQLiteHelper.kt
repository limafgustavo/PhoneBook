package com.gustavolima.myapplicationphonebook

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "phonebook.db"
        private const val TBL_CONTACT = "tbl_contact"
        private const val ID = "id"
        private const val NAME = "name"
        private const val NUMBER = "number"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblContact = (TBL_CONTACT + "("
                + ID + "INTEGER PRIMARY KEY, "
                + NAME + "TEXT,"
                + NUMBER + " TEXT" + ")")
        db?.execSQL(createTblContact)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_CONTACT")
        onCreate(db)
    }
    fun insertPhone(phone: PhoneBookModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, phone.id)
        contentValues.put(NAME, phone.name)
        contentValues.put(NUMBER, phone.number)

        val success = db.insert(TBL_CONTACT, null, contentValues)
        db.close()
        return success
    }

}