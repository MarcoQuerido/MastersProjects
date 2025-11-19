package com.isep.acme.bootstrapper;

import com.isep.acme.model.ProductDTO;
import com.isep.acme.model.ReviewDTO;
import com.isep.acme.model.UserDTO;
import com.isep.acme.model.VoteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RpcResponse {

    List<UserDTO> users;

    List<ProductDTO> products;

    List<ReviewDTO> reviews;

    List<VoteDTO> votes;
}
