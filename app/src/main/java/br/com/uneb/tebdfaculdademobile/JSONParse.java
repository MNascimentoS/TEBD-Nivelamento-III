package br.com.uneb.tebdfaculdademobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.uneb.tebdfaculdademobile.model.DisciplinaValue;
import br.com.uneb.tebdfaculdademobile.persistence.DisciplinaDAO;

//public class JSONParse extends AsyncTask<String, String, JSONObject> {
//    private ProgressDialog pDialog;
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        pDialog = new ProgressDialog(SplashScreen.this);
//        pDialog.setMessage("Obtendo Dados");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(true);
//        pDialog.show();
//    }
//
//    @Override
//    protected void onPostExecute(JSONObject json) {
//        try {
//            pDialog.dismiss();
//            Intent i = new Intent(SplashScreen.this, MainActivity.class);
//            startActivity(i);
//            finish();
//        } catch (Exception e) {
//        }
//    }
//
//
//    @Override
//    protected JSONObject doInBackground(String... args) {
//        JSONObject json = null;
//        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(SplashScreen.this);
//        disciplinaDAO.dropAll();
//        JSONArray link = null;
//        json = Json(); int count=0; try {
//            link = json.getJSONArray("Lista");
//            for (int i = 0; i < link.length(); i++) {
//                JSONObject c = link.getJSONObject(i);
//                DisciplinaValue disciplinaValue = new DisciplinaValue();
//                disciplinaValue.setDisciplina(c.getString("disciplina"));
//                disciplinaDAO.salvar(disciplinaValue);
//                disciplinaDAO.close();
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return json;
//    }
//}