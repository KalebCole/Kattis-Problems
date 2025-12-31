# Kattis Progress Dashboard

A retro-futuristic terminal-style dashboard for tracking your Kattis problem-solving progress.

## Features

- **Live Statistics**: Track solved problems, backlog, and language breakdown
- **Interactive Charts**: Visualize your progress with Chart.js powered graphs
- **Searchable Tables**: Filter and search through all your solved problems
- **Achievement System**: Unlock badges as you hit milestones
- **Retro Aesthetic**: CRT-inspired design with scan lines and neon colors

## Usage

### Quick Start

1. Generate the dashboard with current data:
   ```bash
   python generate_dashboard.py
   ```

2. Open `kattis_dashboard.html` in your browser

### Automated Updates

To automatically update the dashboard when you solve new problems, you can integrate it with your existing build script:

```python
# Add to build.py
import subprocess
subprocess.run(['python', 'generate_dashboard.py'])
```

## Dashboard Components

### Statistics Cards
- **Problems Solved**: Total completed problems (184)
- **In Backlog**: Queued problems to solve (28)
- **Java Solutions**: Problems solved in Java (143)
- **Python Solutions**: Problems solved in Python (41)

### Visualizations
- **Language Distribution**: Pie chart showing Java vs Python usage
- **Status Overview**: Bar chart of solved vs backlog problems
- **Progress Bars**: Overall completion and language ratio tracking

### Tables
- **Solved Problems**: Searchable and filterable table with links to Kattis
- **Backlog Queue**: List of problems waiting to be solved

### Achievements
Unlock badges as you progress:
- 🚀 First Steps (1 problem)
- 💯 Century Club (100 problems)
- 🎯 Sharp Shooter (150 problems)
- 🏆 Champion (200 problems)
- ☕ Java Master (100+ Java)
- 🐍 Python Pro (50+ Python)

## Technical Details

- **Single File**: Standalone HTML file with embedded data
- **No Server Required**: Works offline, can be hosted anywhere
- **Responsive Design**: Works on desktop and mobile
- **Modern Stack**: Chart.js for visualizations, vanilla JS for interactivity

## Customization

Edit `dashboard.html` to customize:
- Colors: Modify CSS variables in `:root`
- Fonts: Change Google Fonts imports
- Charts: Adjust Chart.js configuration
- Achievements: Update achievement criteria in `renderAchievements()`

## Files

- `dashboard.html` - Base template
- `generate_dashboard.py` - Script to scan directories and generate dashboard
- `kattis_dashboard.html` - Generated dashboard with embedded data

## Browser Compatibility

Works in all modern browsers:
- Chrome/Edge 90+
- Firefox 88+
- Safari 14+

Enjoy tracking your competitive programming journey! 🚀
