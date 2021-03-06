package com.evan.chat.data.source.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.evan.chat.gen.LogUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOG_USER".
*/
public class LogUserDao extends AbstractDao<LogUser, Long> {

    public static final String TABLENAME = "LOG_USER";

    /**
     * Properties of entity LogUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property User_id = new Property(1, int.class, "user_id", false, "USER_ID");
        public final static Property Password = new Property(2, String.class, "password", false, "PASSWORD");
        public final static Property Login_time = new Property(3, java.util.Date.class, "login_time", false, "LOGIN_TIME");
        public final static Property Is_auto = new Property(4, int.class, "is_auto", false, "IS_AUTO");
    }


    public LogUserDao(DaoConfig config) {
        super(config);
    }
    
    public LogUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOG_USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_ID\" INTEGER NOT NULL ," + // 1: user_id
                "\"PASSWORD\" TEXT," + // 2: password
                "\"LOGIN_TIME\" INTEGER," + // 3: login_time
                "\"IS_AUTO\" INTEGER NOT NULL );"); // 4: is_auto
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOG_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LogUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUser_id());
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        java.util.Date login_time = entity.getLogin_time();
        if (login_time != null) {
            stmt.bindLong(4, login_time.getTime());
        }
        stmt.bindLong(5, entity.getIs_auto());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LogUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUser_id());
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        java.util.Date login_time = entity.getLogin_time();
        if (login_time != null) {
            stmt.bindLong(4, login_time.getTime());
        }
        stmt.bindLong(5, entity.getIs_auto());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LogUser readEntity(Cursor cursor, int offset) {
        LogUser entity = new LogUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // user_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // password
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // login_time
            cursor.getInt(offset + 4) // is_auto
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LogUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUser_id(cursor.getInt(offset + 1));
        entity.setPassword(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLogin_time(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setIs_auto(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LogUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LogUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LogUser entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
