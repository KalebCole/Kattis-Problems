# 🌐 GitHub Pages Structure

Your Kattis repository now deploys **TWO pages** to GitHub Pages with easy navigation between them!

## 📄 Pages Available

### 1. Interactive Dashboard (Main Page)
**URL:** `https://kalebcole.github.io/Kattis-Problems/`

**Features:**
- 🎨 Retro-futuristic terminal design with CRT effects
- 📊 Interactive charts (Chart.js)
- 🔍 Searchable and filterable problem tables
- 🏆 Achievement badges
- 📈 Real-time statistics and progress bars
- ⚡ Smooth animations

**Navigation:** Click "View Simple Table →" to go to the table page

---

### 2. Simple Table View
**URL:** `https://kalebcole.github.io/Kattis-Problems/table.html`

**Features:**
- 📋 Clean, minimal table design
- 🖼️ Language badge images
- 🔗 Direct links to Kattis problems
- 📱 Responsive layout
- 🎯 Quick reference format

**Navigation:** Click "← Back to Interactive Dashboard" to return

---

## 🔄 How It Works

### Automatic Deployment

When you push to master, GitHub Actions automatically:

1. ✅ Runs `generate_dashboard.py`
2. ✅ Generates `kattis_dashboard.html` with current problem data
3. ✅ Deploys files to GitHub Pages:
   - `kattis_dashboard.html` → `index.html` (main page)
   - `index.html` → `table.html` (simple table)
   - `images/` → `images/` (language badges)
   - `README.md` → `README.md` (documentation)

### File Mapping

```
Local Repository              →    GitHub Pages
─────────────────────────────────────────────────────
kattis_dashboard.html         →    /index.html
index.html (table)            →    /table.html
images/                       →    /images/
README.md                     →    /README.md
```

---

## 🎯 Use Cases

### For Quick Reference
Use the **Simple Table** (`/table.html`):
- Quick scan of all problems
- See language badges at a glance
- Minimal, fast-loading page

### For Progress Tracking
Use the **Interactive Dashboard** (`/`):
- Visualize your progress over time
- Track achievements and milestones
- Search and filter problems
- See detailed statistics

---

## 🔧 Updating Content

### Method 1: Push Changes (Automatic)
```bash
# Solve a new problem
git add Solved/NewProblem.java
git commit -m "Solved: NewProblem"
git push origin master

# Both pages auto-update in ~2 minutes
```

### Method 2: Run Build Script
```bash
python build.py
# This generates both:
# - README.md
# - index.html (styled table)
# - Triggers dashboard generation

git add .
git commit -m "Update problems"
git push origin master
```

### Method 3: Manual Dashboard Generation
```bash
python generate_dashboard.py
# Only updates kattis_dashboard.html locally
# Still need to push for GitHub Pages
```

---

## 🎨 Styling & Theme

Both pages share a cohesive design:

### Dashboard
- **Primary:** Dark blue (#0a0e27)
- **Accent:** Cyan (#00ffff)
- **Secondary:** Magenta (#ff00ff)
- **Style:** Retro-futuristic terminal

### Table
- **Background:** Light gray (#f5f5f5)
- **Table:** White with cyan headers
- **Button:** Cyan (#00ffff)
- **Style:** Clean and minimal

---

## 📱 Responsive Design

Both pages are fully responsive:

- **Desktop:** Full featured, side-by-side charts
- **Tablet:** Stacked charts, compact tables
- **Mobile:** Single column layout, touch-friendly buttons

---

## 🔗 Navigation Flow

```
┌──────────────────────────────┐
│   Interactive Dashboard      │
│   (Root / index.html)         │
│                               │
│   [View Simple Table →]      │
└───────────────┬──────────────┘
                │
                ↓
┌──────────────────────────────┐
│   Simple Table View          │
│   (/table.html)              │
│                               │
│   [← Back to Dashboard]      │
└──────────────────────────────┘
```

---

## 🚀 Sharing Your Pages

### Share the Main Dashboard
```
https://kalebcole.github.io/Kattis-Problems/
```
Best for: Showcasing progress, portfolio, social media

### Share Direct Links to Table
```
https://kalebcole.github.io/Kattis-Problems/table.html
```
Best for: Quick reference, documentation

### Embed in README
```markdown
## My Kattis Progress

📊 [Interactive Dashboard](https://kalebcole.github.io/Kattis-Problems/)
📋 [Problem List](https://kalebcole.github.io/Kattis-Problems/table.html)
```

---

## 🛠️ Customization

### Modify Dashboard
Edit `dashboard.html`:
- Change colors in `:root` CSS variables
- Add/remove charts
- Customize achievements
- Adjust animations

### Modify Table
Edit `build.py` template:
- Update table styling
- Change column layout
- Add additional information
- Modify navigation button

Both changes take effect on next deployment!

---

## ✅ Current Setup

Your pages are configured as:

1. **Main Page (/)**: Interactive Dashboard
   - Full-featured visualization
   - Primary entry point
   - Optimized for engagement

2. **Table Page (/table.html)**: Simple Table
   - Quick reference format
   - Alternative view
   - Optimized for speed

3. **Navigation**: Bidirectional links
   - Easy switching between views
   - Consistent navigation placement
   - Styled to match each page theme

---

## 📊 Analytics (Optional)

To track which page is more popular, add Google Analytics to both:

1. **Dashboard**: Edit `dashboard.html` before `</head>`
2. **Table**: Edit `build.py` template before `</head>`

```html
<script async src="https://www.googletagmanager.com/gtag/js?id=G-XXXXXXXXXX"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-XXXXXXXXXX');
</script>
```

---

## 🎉 Enjoy Your Dual-Page Setup!

You now have the best of both worlds:
- 🎨 Beautiful interactive dashboard for showcasing
- 📋 Simple table for quick reference

Both automatically sync with your problem-solving progress!

**Live URLs:**
- Dashboard: https://kalebcole.github.io/Kattis-Problems/
- Table: https://kalebcole.github.io/Kattis-Problems/table.html
