package app2.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfo {

    @NotNull(message = "Feedback name is empty or null.")
    private String name;
    @NotNull(message = "Feedback email is empty or null.")
    @Email
    private String email;
    @NotNull(message = "Feedback info is empty or null.")
    @Min(10)
    private String feedback;
}
