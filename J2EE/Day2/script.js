// script.js

// Example policy data
const policies = [
    { id: 1, name: 'Policy A', description: 'Description of Policy A' },
    { id: 2, name: 'Policy B', description: 'Description of Policy B' },
    { id: 3, name: 'Policy C', description: 'Description of Policy C' },
    // Add more policies as needed
];

// Function to display policies
function displayPolicies() {
    const policyList = document.getElementById('policyList');
    policyList.innerHTML = policies.map(policy => `
        <div class="card mb-2">
            <div class="card-body">
                <h5 class="card-title">${policy.name}</h5>
                <p class="card-text">${policy.description}</p>
                <button class="btn btn-primary mr-2" onclick="showPolicyDetail(${policy.id})">View Details</button>
            </div>
        </div>
    `).join('');
}

// Function to sort policies by name (ascending)
function sortPoliciesByName() {
    policies.sort((a, b) => a.name.localeCompare(b.name));
    displayPolicies();
}

// Function to show policy detail in a modal
function showPolicyDetail(policyId) {
    const policy = policies.find(p => p.id === policyId);
    document.getElementById('modalPolicyName').textContent = policy.name;
    document.getElementById('modalPolicyDescription').textContent = policy.description;
    $('#policyDetailModal').modal('show');
}

// Initialize the dashboard
document.addEventListener('DOMContentLoaded', function() {
    displayPolicies();
});
