package com.RG4LIFE.Factura.service


import com.RG4LIFE.Factura.model.Client
import com.RG4LIFE.Factura.repository.ClientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

class ClientServiceTest {

    @SpringBootTest
    class ClientServiceTest {

        @InjectMocks
        lateinit var clientService: ClientService //clae que se va a probar

        @Mock   //objeto simulado
        lateinit var clientRepository: ClientRepository

        val clientMock = Client().apply {
            id = 1
            niu = "0301707030"
            fullname = "Juan"
            address = "Cuenca"
            email= "mddv@gmail.com"
        }

        @Test
        fun saveClientCorrect() {
            Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
            val response = clientService.save(clientMock)
            Assertions.assertEquals(response.id, clientMock.id)
        }


        @Test
        fun saveClientWhenFullnameIsBlank() {

            Assertions.assertThrows(Exception::class.java) {
                clientMock.apply { fullname = " " }
                Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
                clientService.save(clientMock)
            }

        }
    }
}