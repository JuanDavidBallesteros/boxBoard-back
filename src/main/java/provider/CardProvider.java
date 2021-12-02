package provider;

import model.Card;
import sql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardProvider {
    private final MySQL db;
    private final String table = "A00306456Cards";

    public CardProvider(){
        db = new MySQL();
    }

    public ArrayList<Card> getData() throws SQLException {
        ArrayList<Card> response = new ArrayList<>();

        String sql = "SELECT * FROM "+ table;
        db.connection();
        ResultSet results = db.getDataMySQL(sql);
        getResponseList(results, response);
        db.close();

        return response;
    }

    private void getResponseList(ResultSet results, ArrayList<Card> list ) throws SQLException {
        while (results.next()) {
            String id = results.getString(results.findColumn("id"));
            String title = results.getString(results.findColumn("title"));
            String description = results.getString(results.findColumn("description"));
            String date = results.getString(results.findColumn("creationDate"));
            String status = results.getString(results.findColumn("cardStatus"));

            Card temp = new Card(id, title, description, date, status);
            list.add(temp);
        }
    }

    public String insert(Card card) throws SQLException {
        String sql = "INSERT INTO " + table +
                " (id, title, description, creationDate, cardStatus)" +
                " VALUES ('$id','$title', '$description', '$date', '$status')";

        sql = replace(sql, card);

        db.connection();
        db.comandSQL(sql);
        db.close();
        return "ok";
    }
    
    public String update(Card card) throws SQLException {
        String sql = "UPDATE " + table +
                " SET `id` = '$id', `title` = '$title', `description` = '$description', " +
                "`creationDate` = '$date', `cardStatus` = '$status' " +
                "WHERE id='$id'";

        sql = replace(sql, card);

        db.connection();
        db.comandSQL(sql);
        db.close();
        return "ok";
    }

    private String replace(String sql, Card card){
        sql = sql.replace("$id", card.getId());
        sql = sql.replace("$title", card.getTitle());
        sql = sql.replace("$description", card.getDescription());
        sql = sql.replace("$date", card.getDate());
        sql = sql.replace("$status", card.getStatus());
        return sql;
    }

    public String delete(String id) throws SQLException {
        String sql = "DELETE from " + table +
                " WHERE id='$id'";
        sql = sql.replace("$id", id);

        db.connection();
        db.comandSQL(sql);
        db.close();

        return "ok";
    }
}
