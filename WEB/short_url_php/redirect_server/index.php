<?php

$id  	= isset( $_GET['id'] ) ? rtrim( trim( $_GET['id'] ), '/' ) : 'default';

$real_id  = alphaID($id, true,4);

if($query_alert = mysqli_query($conn,"SELECT url_go FROM my_table WHERE id='$real_id' ORDER BY id DESC LIMIT 1")){
  
    while($res_al = mysqli_fetch_array($query_alert)){
        $url_go =  $res_al['url_go'];
    }
}

if(mysqli_num_rows($query_alert) > 0){
    $url = $url_go;
}else{
    $url ="https://page_not_found";
}



if ( $url ) {
	header( "X-Robots-Tag: noindex, nofollow", true );
	header( "Location: " .  $url, 302 );
	die;
} else {
	echo '<p>Make sure yor redirects file contains a default value, syntax:</p>
	<pre>default,http://example.com</pre>
	<p>Where you should replace example.com with your domain.</p>';
}


function alphaID($in, $to_num = false, $pad_up = false, $pass_key = null){
    $index = 'abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $base  = strlen($index);
  
    if ($pass_key !== null) {
      for ($n = 0; $n < strlen($index); $n++) {
        $i[] = substr($index, $n, 1);
      }
  
      $pass_hash = hash('sha256',$pass_key);
      $pass_hash = (strlen($pass_hash) < strlen($index) ? hash('sha512', $pass_key) : $pass_hash);
  
      for ($n = 0; $n < strlen($index); $n++) {
        $p[] =  substr($pass_hash, $n, 1);
      }
  
      array_multisort($p, SORT_DESC, $i);
      $index = implode($i);
    }
  
    if ($to_num) {
      // Digital number  <<--  alphabet letter code
      $out=0;
      $len = strlen($in) - 1;
  
      for ($t = $len; $t >= 0; $t--) {
        $bcp = bcpow($base, $len - $t);
        $out = $out + strpos($index, substr($in, $t, 1)) * $bcp;
      }
  
      if (is_numeric($pad_up)) {
        $pad_up--;
  
        if ($pad_up > 0) {
          $out -= pow($base, $pad_up);
        }
      }
    } else {
      // Digital number  -->>  alphabet letter code
      $out ='';
      if (is_numeric($pad_up)) {
        $pad_up--;
  
        if ($pad_up > 0) {
          $in += pow($base, $pad_up);
        }
      }
  
      for ($t = ($in != 0 ? floor(log($in, $base)) : 0); $t >= 0; $t--) {
        $bcp = bcpow($base, $t);
        $a   = floor($in / $bcp) % $base;
        $out = $out . substr($index, $a, 1);
        $in  = $in - ($a * $bcp);
      }
    }
  
    return $out;
  }
  
?>