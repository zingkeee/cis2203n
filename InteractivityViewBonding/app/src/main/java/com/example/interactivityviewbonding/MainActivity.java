package interactivityviewbonding;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interactivityviewbonding.databinding.ActivityMainBinding; // Make sure your package name matches

public class MainActivity extends AppCompatActivity {

    // The modern ViewBinding object
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // The Event Listener
        binding.btnSubmit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        // 1. Get the text from the inputs
        String idInput = binding.etStudentId.getText().toString().trim();
        String passwordInput = binding.etPassword.getText().toString().trim();

        // 2. Set the lab wall color (IMPORTANT: Change "white" to your actual lab's color!)
        String wallColor = "peach";

        if (idInput.length() >= 2) {
            // 3. Extract the last two digits of the ID
            String lastTwoDigits = idInput.substring(idInput.length() - 2);
            String requiredPassword = wallColor + lastTwoDigits; // e.g., "white22"

            // 4. Validate the password exactly
            if (passwordInput.equals(requiredPassword)) {
                binding.tvResult.setText("Access Granted!");
            } else {
                binding.tvResult.setText("Access Denied: Incorrect Password.");
            }
        } else {
            binding.tvResult.setText("Please enter a valid Student ID.");
        }
    }
}