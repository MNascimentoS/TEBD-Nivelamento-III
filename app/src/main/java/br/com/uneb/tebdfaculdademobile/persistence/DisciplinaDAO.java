package br.com.uneb.tebdfaculdademobile.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import br.com.uneb.tebdfaculdademobile.model.DisciplinaValue;

public class DisciplinaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoDisciplina";
    private static int VERSION = 1;

    public DisciplinaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ddl = "CREATE TABLE Disciplina (id INTEGER PRIMARY KEY," +
                "disciplina TEXT UNIQUE NOT NULL);";
        sqLiteDatabase.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String ddl = "DROP TABLE IF EXISTS Disciplina";
        sqLiteDatabase.execSQL(ddl);
        onCreate(sqLiteDatabase);
    }

    public void	salvar(DisciplinaValue disciplinaValue)	{
        ContentValues values	=	new ContentValues();
        values.put("disciplina",	disciplinaValue.getDisciplina());
        getWritableDatabase().insert("Disciplina",	null,	values	);
    }

    public List getLista(){
        List<DisciplinaValue>	disciplinas	=	new LinkedList<DisciplinaValue>();
        String	query	=	"SELECT		*	FROM	"	+	"Disciplina	order by	disciplina";
        SQLiteDatabase db	=	this.getWritableDatabase();
        Cursor cursor	=	db.rawQuery(query,	null);
        DisciplinaValue	disciplina	=	null;
        if	(cursor.moveToFirst())	{
            do	{
                disciplina	= new DisciplinaValue();
                disciplina.setId(Long.parseLong(cursor.getString(0)));
                disciplina.setDisciplina(cursor.getString(1));
                disciplinas.add(disciplina);
            }	while	(cursor.moveToNext());
        }
        return	disciplinas;
    }

    public void	deletar(DisciplinaValue disciplinaValue)	{
        String[]	args	=	{	String.valueOf(disciplinaValue.getId())	};
        getWritableDatabase().delete("Disciplina",	"id=?",	args);
    }

    public void	alterar(DisciplinaValue	disciplina)	{
        ContentValues values	=	new	ContentValues();
        values.put("disciplina",	disciplina.getDisciplina());
        getWritableDatabase().update("Disciplina",	values,
                "id=?",	new	String[]{String.valueOf(disciplina.getId())});
    }

    public void dropAll () {
//        getWritableDatabase().delete("Disciplina", "id!=", null);
    }
}
