package tech.paulosalgado.puc.compliance.infrastructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class InfraController {

    @GetMapping
    public String getLocalHostInfo() throws UnknownHostException {
        return InetAddress.getLocalHost().toString();
    }

}
