package br.example.assynctask;

import android.os.AsyncTask;

import java.net.URL;

public class TesteAsyncTask extends AsyncTask<Integer, Integer, Long> {
    MeuListener listener = null;

    public TesteAsyncTask(MeuListener listener) {
        this.listener = listener;
    }

    protected void onPreExecute() {
// ...
    }

    protected Long doInBackground(Integer... params) {
        int n = params[0];
        long cont = 0;
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cont += i;
            publishProgress(i);
        }
        return cont;
    }

    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        listener.onProgress(progress[0]);
    }

    protected void onPostExecute(Long result) {
        super.onPostExecute(result);
        listener.onResult(result);
    }
}
