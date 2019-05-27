
var baseUrlContext = 'http://localhost:8080/demo/products/';

function createProduct(product){
	fetch(baseUrlContext + 'create',{
		method: 'post',
		
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body:JSON.stringify(product)
	}).then(function(response){
		return response.json();
	}).then(function(data){
		alert('Product Created');
		console.log(JSON.stringify(data));
	}).catch(function(){
		alert('Error in fetching data');
	});
}

function deleteProduct(productId){
	fetch(baseUrlContext + 'delete/' + productId,{
		method: 'delete',
		
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(function(response){
		return response.json();
	}).then(function(data){
		alert('Product Deleted');
		console.log(JSON.stringify(data));
	}).catch(function(){
		alert('Error in deleting data');
	});
}

function updateProduct(productId, product){
	fetch(baseUrlContext + 'update/' + productId,{
		method: 'put',
		headers: {
			'Content-Type': 'application/json'
		},
		body:JSON.stringify(product)
	}).then(function(response){
		return response.json();
	}).then(function(data){
		alert('Product Updated');
		console.log(JSON.stringify(data));
	}).catch(function(){
		alert('Error in updating data');
	});
}

async function findProduct(productId){
	let response = fetch(baseUrlContext + 'read/' + productId,{
		method: 'get',
		headers: {
			'Content-Type': 'application/json'
		}
	});
	if (response.ok) { // if HTTP-status is 200-299
		// get the response body (see below)
		let json = response.json();
		console.log(json);
		return json.body;
	} else {
	  alert("HTTP-Error: " + response.status);
	}
}

