 <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>

    <script type="text/javascript">
        var ws = null;
       $(function(){
       	connect();
       });
      
        function connect() {
         	var url = '/cloudcode/sockjs/websocket';
            if (!url) {
                alert('Select whether to use W3C WebSocket or SockJS');
                return;
            }
            //ws = (url.indexOf('sockjs') != -1) ?new SockJS(url, undefined, {protocols_whitelist: transports}) : new WebSocket(url);
            if ('WebSocket' in window) {
                ws= new WebSocket("ws://${ip}:${port}/${request.getContextPath()}/websck");
            }else {
                ws = new SockJS("http://${ip}:${port}/${request.getContextPath()}/sockjs/websck");
            }
            //websocket = new SockJS("http://localhost:8080/cloudcode/sockjs/websck");
            ws.onopen = function () {
                //alert('open');
                //setConnected(true);
                //log('Info: connection opened.');
            };
            ws.onmessage = function (event) {
                alert( event.data);
                //log('Received: ' + event.data);
            };
            ws.onclose = function (event) {
                //setConnected(false);
                //log('Info: connection closed.');
               // log(event);
            };
        }
          </script>