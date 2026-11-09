package br.com.helptech.v3;
import android.app.Activity;import android.os.Bundle;import android.webkit.WebView;import android.webkit.WebViewClient;import androidx.webkit.WebViewAssetLoader;
public class MainActivity extends Activity {
 WebView view;
 @Override public void onCreate(Bundle b){super.onCreate(b);view=new WebView(this);view.getSettings().setJavaScriptEnabled(true);view.getSettings().setDomStorageEnabled(true);WebViewAssetLoader loader=new WebViewAssetLoader.Builder().addPathHandler("/assets/",new WebViewAssetLoader.AssetsPathHandler(this)).build();view.setWebViewClient(new WebViewClient(){@Override public android.webkit.WebResourceResponse shouldInterceptRequest(WebView v,android.webkit.WebResourceRequest r){return loader.shouldInterceptRequest(r.getUrl());}});setContentView(view);view.loadUrl("https://appassets.androidplatform.net/assets/index.html");}
 @Override public void onBackPressed(){if(view.canGoBack())view.goBack();else super.onBackPressed();}
}