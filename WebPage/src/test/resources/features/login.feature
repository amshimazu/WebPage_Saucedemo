#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items y realizar una compra

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Saucedemo
    Cuando inicio sesión con las credenciales usuario: "standard_user" y contraseña: "secret_sauce"
    Entonces valido que debería aparecer el título de "Products"
    Y también valido que al menos exista un item
    Y selecciono un producto
    Entonces Valido que debería aparecer "Back to products"
    Y agrego el producto al carrito
    Y regreso a la lista de productos
    Y selecciono un segundo producto
    Entonces Valido que debería aparecer "Back to products"
    Y agrego el segundo producto al carrito
    Y regreso a la lista de productos
    Entonces valido que en el carrito de compras deba aparecer 2
    Y hago click en el carrito de compras
    Entonces valido que deberia aparecer el titulo de "Your Cart"
    Y retiro el segundo producto
    Entonces valido que en el carrito de compras deba aparecer 1
    Y hago click en checkout
    Entonces valido que aparezca el titulo de "Checkout: Your Information"
    Y completo los datos del usuario: "First Name", "Last Name" y "Postal Code"
    Y finalizo mi compra
    Entonces  debe mostrar el mensaje "Thank you for your order!"


