var nodes = ['a','abbr','acronym','address','applet','area','b','base','basefont','bdo','big','blockquote','body','br','button','caption','center','cite','code','col','colgroup','dd','del','dfn','dir','div','dl','dt','em','fieldset','font','form','frame','frameset','h1','h2','h3','h4','h5','h6','head','hr','html','i','iframe','img','input','ins','isindex','kbd','label','legend','li','link','map','menu','meta','noframes','noscript','object','ol','optgroup','option','p','param','pre','q','s','samp','script','select','small','span','strike','strong','style','sub','sup','table','tbody','td','textarea','tfoot','th','thead','title','tr','tt','u','ul','var','xmp'],
    i = 0,
    nodesLength = nodes.length,
    nodesCount = {},
    output = [document.location],
    scheffieldScript;

function scheffield_count () {
	for (i; i < nodesLength; i++) {
		var node = nodes[i],
		nodeOccurence = jQuery(node).length;
		nodesCount[node] = nodeOccurence;
		output.push(nodeOccurence);
	}
	
	console.debug(output.join(','));
}

if (typeof jQuery === 'undefined') {
	console.debug('no jquery, fix this...');
	
	scheffieldScript = document.createElement("script");
	scheffieldScript.onload = scheffield_count;
	scheffieldScript.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js';
	document.body.appendChild(scheffieldScript);
} else {
	scheffield_count();
}