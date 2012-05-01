<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>jQuery UI Example Page</title>
		<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
                <script>
                $(function() {
                        $( "#sortable" ).sortable({
                              stop: function(event, ui) {
                                  alert("The paragraph is now hidden");
                              }
                            });
                        $( "#sortable" ).disableSelection();
                });
                </script>

		<style type="text/css">
			/*demo page css*/
			body{ font: 62.5% "Trebuchet MS", sans-serif; margin: 50px;}
			.demoHeaders { margin-top: 2em; }
			#dialog_link {padding: .4em 1em .4em 20px;text-decoration: none;position: relative;}
			#dialog_link span.ui-icon {margin: 0 5px 0 0;position: absolute;left: .2em;top: 50%;margin-top: -8px;}
			ul#icons {margin: 0; padding: 0;}
			ul#icons li {margin: 2px; position: relative; padding: 4px 0; cursor: pointer; float: left;  list-style: none;}
			ul#icons span.ui-icon {float: left; margin: 0 4px;}
		</style>
	</head>
	<body>
            <style>
            #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
            #sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
            #sortable li span { position: absolute; margin-left: -1.3em; }
            </style>

            <div class="demo">

            <ul id="sortable">
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 1</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 2</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 3</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 4</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 5</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 6</li>
                    <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 7</li>
            </ul>

            </div><!-- End demo -->

            <input value="1234" id="test"></button>

	</body>
</html>