Feature: Registrarse en parabank y verificar el registro
  Yo como usuario
  Necesito registrarme en la página parabank
  Para validar que el registro fue exitoso

  Scenario: Registrarse en parabank
    Given Deseo abrir la pagina parabank "https://parabank.parasoft.com/"
    When ingreso a la opcion de Register
    When ingreso los siguientes datos para mi registro: First Name: "John", Last Name: "Doe", Address: "123 Main St", City: "Anytown", State: "Anystate", Zip Code: "12345", Phone: "123-456-7890", SSN: "123-45-6789", Username: "johndoe", Password: "password", Confirm: "password"
    When presiono el boton Open New Account y en el select escogemos "SAVINGS"
    When luego presiono el boton Open New Account
    When guardo el numero Your new account number
    Then valido que la cuenta exista en la opcion de Accounts Overview
